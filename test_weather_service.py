import unittest
from weather_service import WeatherService
import datetime
from unittest.mock import patch, Mock
from datetime import datetime as real_datetime

class MockWeatherService(WeatherService):
    def _get_weather_data(self, city: str):
        return {'main': {'temp': 35}}

class WeatherServiceTest(unittest.TestCase):
    def setUp(self):
        self.ws = MockWeatherService(api_url='URL', api_key='KEY')

    def test_get_temperature(self):
        temp = self.ws.get_temperature('Chicago')
        self.assertEqual(temp, 35)

    def test_is_hot_day(self):
        isHot = self.ws.is_hot_day('Chicago')
        self.assertEqual(isHot, True)
        isHot2 = self.ws.is_hot_day('Chicago', threshold=40)
        self.assertEqual(isHot2, False)

    def test_get_greeting(self):    
        with patch('weather_service.datetime') as mock_datetime:
            mock_datetime.now.return_value = real_datetime(2025, 1, 1, 14, 0, 0)
            # also allow constructor calls to behave like real datetime
            mock_datetime.side_effect = lambda *args, **kwargs: real_datetime(*args, **kwargs)

            greeting = self.ws.get_greeting('Zach')
            self.assertEqual(greeting, "Good afternoon, Zach!")

if __name__ == '__main__':
    unittest.main()