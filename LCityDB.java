/**
 *  Definition of a singly linked list node
 */

class LCityDB<E> {
    public class Node<City> {
        private City value;
        private Node<City> next;

        public Node(City value) {
        this.value = value;
        this.next = null;
        }

        public City getValue() {
        return value;
        }

        public Node<City> getNext() {
        return next;
        }

        public void setValue(City value) {
        this.value = value;
        }

   

        public void setNext(Node<City> next) {
        this.next = next;
        }
}
    private Node<City> head;
    private int size;
    private int maxSize;

    public LCityDB() {
        this.head = null;
        this.size = 0;
        this.maxSize = 30000;
    }

    //insert records
    public void insert(City c) {
        assert size < maxSize : "Database is full.";
        Node<City> newNode = new Node<>(c);
        if (head == null) {
            head = newNode;
        } else {
            Node<City> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    //Delete records by name (city and state)
    // n: name; s: state;
    public void delete(String n, String s) {
        Node<City> currentNode = head;
        Node<City> prevNode = null;
        while (currentNode != null) {
            if (currentNode.getValue().getName().equals(n) && currentNode.getValue().getState().equals(s)) {
                if (prevNode == null) {
                    head = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                size--;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    //Delete records by coordinate
    // lat: latitude; lon: longitude
    public void delete(double lat, double lon) {
        Node<City> currentNode = head;
        Node<City> prevNode = null;
        while (currentNode != null) {
            if (currentNode.getValue().getLat() == lat && currentNode.getValue().getLon() == lon) {
                if (prevNode == null) {
                    head = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                size--;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    //Search by name (city and state)
    public City search(String n, String s) {
        Node<City> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().getName().equals(n) && currentNode.getValue().getState().equals(s)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    //Search by coordinate
    public City search(double lat, double lon) {
        Node<City> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().getLat() == lat && currentNode.getValue().getLon() == lon) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }


    //Print all names of cities with a given name of state s.
    public void printAllState(String s) {
        Node<City> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().getState().equals(s)) {
                System.out.println(currentNode.getValue().getName());
            }
            currentNode = currentNode.getNext();
        }
    }
    
    //Print all names of cities and their states within a given distance (d) from a specified point (lat, lon).
    public void printAllDistance(double lat, double lon, double d){
        Node<City> s = head; // s is initialized to the head of the linked list
        while (s != null) {
            double dx = lat - s.getValue().getLat();
            double dy = lon - s.getValue().getLon();
            double distance = Math.sqrt(dx*dx + dy*dy);
            if(distance <= d){
                System.out.println(s.getValue().getName()+","+s.getValue().getState());
            }
            s = s.getNext(); // move to the next node
        }
    }
    
    //Print all names of cities and their states with a given range of population (from, to).  
    public void printAllPopulation(int from, int to){
        Node<City> s = head; // s is initialized to the head of the linked list
        while (s != null) {
            if(from <= s.getValue().getPop() && s.getValue().getPop() <= to){
                System.out.println(s.getValue().getName()+","+s.getValue().getState());
            }
            s = s.getNext(); // move to the next node
        }
    }
    }


    
            