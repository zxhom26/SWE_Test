import unittest
from fibonacci import fibonacci

class TestFibonacci(unittest.TestCase):

    def test_fibonacci_zero(self):
        """F(0) should be 0"""
        self.assertEqual(fibonacci(0), 0)

    def test_fibonacci_positive(self):
        """F(7) should be 13"""
        self.assertEqual(fibonacci(7), 13)

    def test_fibonacci_negative_input(self):
        """Negative inputs should raise ValueError"""
        with self.assertRaises(ValueError):
            fibonacci(-5)

if __name__ == "__main__":
    unittest.main()
