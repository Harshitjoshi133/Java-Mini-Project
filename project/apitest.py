import requests

def get_movies_in_theaters(api_key, city):
    # Fetch a list of theaters near the given city
    url = "https://api.themoviedb.org/3/discover/movie"
    params = {
        'api_key': api_key,
        'language': 'en-US',
        'sort_by': 'popularity.desc',
        'include_adult': 'false',
        'include_video': 'false',
        'page': 1,
        'with_release_type': 3,  # Theatrical release
        'with_watch_providers': '8',  # Filter by theaters (TMDb IDs: 8)
        'region': 'IN',  # Region for India
        'timezone': 'Asia/Kolkata',  # Timezone for India
        'with_release_type.dates.lte': '2024-04-30',  # Upcoming within a certain date range
        'with_watch_providers.lte': '8',  # Limit to theaters
        'with_release_type.gte': '2024-04-01',  # Starting from April 1, 2024
        'with_watch_providers.gte': '8',
    }

    # Get the geographic coordinates of the specified city
    geocode_url = "https://api.opencagedata.com/geocode/v1/json"
    geocode_params = {
        'q': city,
        'key': 'YOUR_OPENCAGE_API_KEY'  # Replace with your OpenCage API key
    }

    # Fetch geographic coordinates (latitude, longitude) for the city
    response = requests.get(geocode_url, params=geocode_params)
    if response.status_code == 200:
        location_data = response.json()
        if location_data['results']:
            coordinates = location_data['results'][0]['geometry']
            params['with_watch_providers.region'] = 'IN'
            params['with_watch_providers.lat'] = coordinates['lat']
            params['with_watch_providers.lon'] = coordinates['lng']
            
            # Make API request to fetch movies in theaters near the city
            movies_response = requests.get(url, params=params)
            if movies_response.status_code == 200:
                movies_data = movies_response.json()
                return movies_data['results']
            else:
                print(f"Failed to fetch movies: {movies_response.status_code}")
                return []
        else:
            print(f"Location data not found for {city}")
            return []
    else:
        print(f"Failed to fetch location data: {response.status_code}")
        return []

# Example usage for Delhi, India
api_key = '98f385da8c65d445e74474d96f6bf466'
city = 'Delhi, India'
movies_in_delhi = get_movies_in_theaters(api_key, city)
for movie in movies_in_delhi:
    print(movie['title'])
