import os

class FileManager:
    def __init__(self, base_path: str):
        self.base_path = base_path

    def list_files(self):
        """Return a list of filenames in the base directory."""
        return os.listdir(self.base_path)

    def file_exists(self, filename: str) -> bool:
        """Return True if the file exists in the base directory."""
        return os.path.isfile(os.path.join(self.base_path, filename))

    def read_file(self, filename: str) -> str:
        """Read and return the contents of a file."""
        path = os.path.join(self.base_path, filename)
        with open(path, 'r') as f:
            return f.read()

    def count_lines(self, filename: str) -> int:
        """Return the number of lines in a file."""
        content = self.read_file(filename)
        return len(content.splitlines())
