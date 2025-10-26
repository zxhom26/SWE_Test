from file_manager import FileManager
import os
from unittest.mock import patch
import unittest

class MockFileManager(FileManager):
    def read_file(self, filename: str):
        return ("This is a test file.\n",
                "I don't know how many lines this is.\n",
                "Hopefully four.\n",
                "I guess we'll find out.\n")

class TestFileManager(unittest.TestCase):
    def setUp(self):
        self.fs = MockFileManager(base_path='mock_base_path')

    def test_list_files(self):
        with patch('file_manager.os.listdir') as mock_listdir:
            mock_listdir.return_value = ['file1', 'file2', 'file3', 'file4']
            ex_list = self.fs.list_files()
            self.assertEqual(ex_list, ['file1', 'file2', 'file3', 'file4'])

    def test_file_exists(self):
        with patch('file_manager.os.path.isfile') as mock_isfile:
            mock_isfile.return_value = True
            exists = self.fs.file_exists('file1')
            self.assertEqual(exists, True)

    def test_count_lines(self):
        num_lines = self.fs.count_lines('file1')
        self.assertEqual(num_lines, 4)

if __name__ == '__main__':
    unittest.main()