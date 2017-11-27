import unittest

from mymath import muliple


class MyTest(unittest.TestCase):
    def setup(self):
        pass

    def testMultiplication(self):
        result = muliple.doThis(2, 2)

        expected = 4
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
