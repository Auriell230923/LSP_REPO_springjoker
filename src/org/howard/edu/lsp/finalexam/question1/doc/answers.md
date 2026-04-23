Part 1:

Shared Resource #1:
The nextId variable.

Shared Resource #2:
The requests list.

Concurrency Problem:
A race condition can happen. If multiple threads run addRequest() at the same time, they can mess with the shared data. This can lead to duplicate IDs or incorrect data in the list.

Why addRequest() is unsafe:
addRequest() is unsafe because it does multiple things (getting an ID and adding to the list) without protection. Another thread can interrupt before it finishes, which can cause problems.

Part 2:

Fix A:
public synchronized int getNextId() { ... }

Fix A is not correct. It only protects the ID generation. The rest of addRequest() is still unsafe, especially adding to the list. Another thread can still interrupt in between.

Fix B:
public synchronized void addRequest(String studentName) { ... }

Fix B is correct. It locks the entire method, so only one thread can run addRequest() at a time. This protects everything: getting the ID, making the request, and adding it to the list.

Fix C:
public synchronized List<String> getRequests() { ... }

Fix C is not correct. It only protects reading the list, but the real issue happens when adding requests. So the main problem is still there.

Part 3:

Answer + Explanation

No, getNextId() should not be public.

This method is just helping the class do its job, so other classes don’t need to use it. Based on what we learned, classes should hide their internal details. Keeping it private makes the code cleaner and safer.

Part 4:

Description:
Instead of using synchronized, we can use a Lock (like ReentrantLock). This lets us control when a thread can enter the important part of the code. Only one thread at a time can run that section.

Code Snippet:

private final Lock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}