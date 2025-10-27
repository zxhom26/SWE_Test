class UserService:
    def __init__(self, database):
        """Database is an injected dependency (e.g., a DB client)."""
        self.db = database

    def get_user(self, user_id):
        """Fetch a single user by ID."""
        user = self.db.fetch_user(user_id)
        if not user:
            raise ValueError("User not found")
        return user

    def create_user(self, username, email):
        """Create a new user and return the created record."""
        if self.db.user_exists(username):
            raise ValueError("Username already exists")
        user = {"username": username, "email": email}
        self.db.insert_user(user)
        return user

    def delete_user(self, user_id):
        """Delete a user if they exist."""
        user = self.db.fetch_user(user_id)
        if not user:
            return False
        self.db.remove_user(user_id)
        return True
