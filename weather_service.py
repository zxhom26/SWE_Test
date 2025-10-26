import requests
from datetime import datetime

class WeatherService:
    def __init__(self, api_url: str, api_key: str):
        self.api_url = api_url
        self.api_key = api_key

    def _get_weather_data(self, city: str):
        """Private helper that calls an external weather API."""
        response = requests.get(
            f"{self.api_url}/weather",
            params={"q": city, "appid": self.api_key, "units": "metric"},
            timeout=5
        )
        response.raise_for_status()
        return response.json()

    def get_temperature(self, city: str):
        """Returns the current temperature for the given city."""
        data = self._get_weather_data(city)
        return data["main"]["temp"]

    def is_hot_day(self, city: str, threshold: float = 30.0):
        """Returns True if the temperature is above the threshold."""
        temp = self.get_temperature(city)
        return temp > threshold

    def get_greeting(self, name: str):
        """Returns a greeting depending on the time of day."""
        hour = datetime.now().hour
        if 5 <= hour < 12:
            return f"Good morning, {name}!"
        elif 12 <= hour < 18:
            return f"Good afternoon, {name}!"
        else:
            return f"Good evening, {name}!"
