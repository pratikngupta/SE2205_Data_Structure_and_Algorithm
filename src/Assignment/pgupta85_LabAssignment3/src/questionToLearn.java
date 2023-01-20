/*
1. What is the goal of using hashing technique in Data Structure?
-- To store the data in a way that it can be retrieved in O(1) time

2. What is the difference between hashing and sorting?
-- Sorting is used to sort the data in ascending or descending order. Hashing is used to store the data in a way that it can be retrieved in O(1) time.

3. What is the difference between hash table and hash map?
-- Hash table is a data structure that stores the data in a way that it can be retrieved in O(1) time. Hash map is a data structure that stores the data in a way that it can be retrieved in O(1) time. It is similar to hash table, but it is not synchronized.

5. What is the difference between hash table and hash set?
-- Hash table is a data structure that stores the data in a way that it can be retrieved in O(1) time. Hash set is a data structure that stores the data in a way that it can be retrieved in O(1) time. It is similar to hash table, but it does not store the data in key-value pair.

6. Explain linear, quadratic, double hashing probing techniques?
-- All of them is a collision resolution technique which is used to resolve the collision in hash table.
-- Linear probing use the formula (hash(key) + i) % size to find the next index to store the data.
-- Quadratic probing use the formula (hash(key) + i^2) % size to find the next index to store the data.
-- Double hashing probing use the formula (hash(key) + i * hash2(key)) % size to find the next index to store the data.

7. What are the advantages of using open addressing over linear chaining? What is the price you pay to enjoy those advantages?
-- Open addressing is faster than linear chaining.
-- The price you pay to enjoy those advantages is that open addressing does not allow duplicate values.
-- also Open addressing is not memory efficient as linear chaining.

time complexity of Quadratic Probing
-- O(1) for search, insert, delete
-- O(n) for worst case
-- O(n) for average case

time complexity of Double Hashing
-- O(1) for search, insert, delete
-- O(n) for worst case
-- O(n) for average case

time complexity of Linear Probing
-- O(1) for search, insert, delete
-- O(n) for worst case
-- O(n) for average case

space complexity of Quadratic Probing
-- O(n)

space complexity of Double Hashing
-- O(n)

space complexity of Linear Probing
-- O(n)

what is q value for double hashing
-- q is the size of the hash table
-- q is the prime number that is less than the size of the hash table,
-- how to find q?
-- q = size of the hash table - 1

8. Best case and worst case time complexity of linear probing while inserting, searching and deleting?
-- Best case time complexity of linear probing while inserting, sorting and deleting is O(1).
-- why? because if there is no collision then it will take O(1) time to insert, sort and delete the data.
-- Worst case time complexity of linear probing while inserting, sorting and deleting is O(n).
-- why? because if there is collision then it will take O(n) time to insert, sort and delete the data.

9. Best case and worst case time complexity of quadratic probing while inserting, searching and deleting?
-- Best case time complexity of quadratic probing while inserting, sorting and deleting is O(1).
-- why? because if there is no collision then it will take O(1) time to insert, sort and delete the data.
-- Worst case time complexity of quadratic probing while inserting, sorting and deleting is O(n).
-- why? because if there is collision then it will take O(n) time to insert, sort and delete the data.

10. Best case and worst case time complexity of double hashing probing while inserting, searching and deleting?
-- Best case time complexity of double hashing probing while inserting, sorting and deleting is O(1).
-- why? because if there is no collision then it will take O(1) time to insert, sort and delete the data.
-- Worst case time complexity of double hashing probing while inserting, sorting and deleting is O(n).
-- why? because if there is collision then it will take O(n) time to insert, sort and delete the data.

11. What is load factor. How does it play a role in hashing?
-- Load factor is the ratio of number of elements in the hash table to the size of the hash table.
-- It plays a role in hashing because if the load factor is greater than 0.7 then it will increase the size of the hash table.
-- It will increase the size of the hash table because if the load factor is greater than 0.7 then it will increase the collision, and it will increase the time complexity of the hash table.
-- It will increase the time complexity of the hash table because if the load factor is greater than 0.7 then it will increase the collision, and it will increase the time complexity of the hash table.

12. What is the use of ‘available’ flag in hashing?
-- The use of ‘available’ flag in hashing is to check if the data is available or not.

13. Based on the background provided in the lecture hand out, explain/show how (by drawing on the screen) for each run in both questions, a linear chain can be constructed.
-- In question 1, the linear chain is constructed by using the formula (hash(key) + i) % size to find the next index to store the data.
-- In question 2, the linear chain is constructed by using the formula (hash(key) + i^2) % size to find the next index to store the data.

14. Explain/demonstrate how in q-2, run-2 the quadratic probing failed due to a load factor of greater than 0.5. Will this always happen? Demonstrate it using the following data set with a load factor of 0.75 in the order as shown: -7, 13, -29 40, 54.
-- In q-2, run-2 the quadratic probing failed due to a load factor of greater than 0.5 load factor is 0.75.
-- It will not always happen

15. Demonstrate by hand what would be content of a hash-table when the data set from above (Q7) is used with load factor 0.75 for each of the following cases: linear probing resolve collision, quadratic probing resolve collision, double - hashing resolve collision, linear-chaining resolve collision.
-- In linear probing resolve collision, the content of a hash-table is [-7, -29, 54, null, null, 40, 13]
-- In quadratic probing resolve collision, the content of a hash-table [-7, null, 54, -29, null, 40, 13]
-- in double- hashing resolve collision, the content of a hash-table is [-7, -29, 54, null, null, 40, 13]

16. For the open addressing techniques, run your code and demonstrate that your code for open addressing is working fine. (The TAs will have the results).
-- The code is working fine.

17. What is rehashing? Why is it required? How to accomplish this task. Explain how did you write the code for rehashing?
-- Rehashing is the process of increasing the size of the hash table.
-- It is required because if the load factor is greater than 0.7 then it will increase the collision, and it will increase the time complexity of the hash table.
-- Formula to accomplish this task is size = size * 2 + 1.
-- First I create a new hash table with double the size of the old hash table.
-- Then I copy all the data from the old hash table to the new hash table.
-- then I will point new hash table to the old hash table.

18. Explain the method checkPrime()? Why is it required? How does it work?
-- checkPrime() is a method that checks if the number is prime or not.
-- It is required because if the size of the hash table is not prime then it will increase the collision, and it will increase the time complexity of the hash table.
-- It works by checking if the number is divisible by any number other than 1 and itself.

19. Explain how the removeValue() method works. What is the time complexity of this method?
-- removeValue() method works by first finding the index of the data using the hash function.
-- Then it will check if the data is available or not.
-- If the data is available then it will remove the data by setting it to "Available".
-- If the data is not available then it will return false.
-- Time complexity of this method is O(n).

20. It seems to be much easier approach if we overwrite the hash table with no argument constructors, every time instead of defining a public static void method called emptyHashTable() method, which will reset the hashTable with values -1 (null-flag). What is the rationale behind defining this method?
-- The rationale behind defining this method is that it will be easier to test the code.
-- It will be easier to test the code because if we overwrite the hash table with no argument constructors, every time then we will have to create a new object of the class every time we want to test the code.

* */
