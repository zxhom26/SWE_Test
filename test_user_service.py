import unittest
from user_service import UserService

class MockUserDatabase():
    def __init__(self):
        self.id = 1234
        self.username = 'zxhom'
        self.email = 'zxhom26@gmail.com'
        self.db = {self.id: {
                            'username':self.username,
                            'email':self.email
                            }
                   }

    def fetch_user(self, user_id):
        if user_id in self.db.keys():
            return self.db[user_id]
        else: return False
    
    def user_exists(self, username):
        exists = False
        for user_id in self.db.keys():
            if username == user_id['username']:
                exists = True
        return exists

    
    def insert_user(self, user):
        self.usernames.append(user)
    
    def remove_user(self, user_id):
        if user_id in self.db.keys():
            self.db.pop(user_id)

class TestUserService(unittest.TestCase):
    def setUp(self):
        self.db = MockUserDatabase()
        self.user_service = UserService(self.db)

    def test_get_user(self):
        test_user = self.user_service.get_user(1234)
        self.assertEqual(test_user, {'username': 'zxhom', 'email':'zxhom26@gmail.com'}})

    def test_create_user(self):
        test_user = self.user_service.create_user('terra', 'terra@gmail.com')
        self.assertEqual(test_user, {"username": 'terra', "email": 'terra@gmail.com'})

    def test_delete_user(self):
        test1 = self.user_service.delete_user(1234)
        self.assertEqual(test1, True)
        test2 = self.user_service.delete_user(6666)
        self.assertEqual(test2, False)














if __name__ == '__main__':
    unittest.main()