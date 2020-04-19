class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    left = null;
    right = null;

  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.

    myValue = A[0];

    for(int i = 1; i < A.length; i++){
      this.insert(A[i]);
    }
  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // recursive method
    // If the value already exists in the tree, no action is taken.
    //if inValue is equal to the node's value we are looking at, then do not insert a new node into the tree
    // as duplicate values are not allowed.


    if(inValue == myValue){
      //print out an error to the user
      System.out.println("Error: Duplicate values not allowed, cannot insert this value.");
    }
    else if(inValue > myValue){ // if the value we want to add is greater than the node(we are visiting)'s value
                          // try to add it to the tree
      if(right == null){
        // if the right branch is NULL, create a new  right node with and insert the data inValue.
        right = new myBinarySearchTreeNode(inValue);
      }else{
        // if the right branch is not NULL, make a recursive call with us visiting the right node now and try to insert inValue into right's subtree.
        right.insert(inValue);
      }
    }else{
      if(inValue < myValue){// if the value we want to add is less than the node(we are visiting)'s value
                            // try to add it to the tree
        if(left == null){
          left = new myBinarySearchTreeNode(inValue);
        }else{
          left.insert(inValue);
        }
      }
    }
    
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int LHeight = 0;
    int RHeight = 0;
    //if the left node is not NULL, we can visit it.
    if(left != null){
       LHeight = left.height(); // recursively increment
    }
    // if the right node is not NULL, we can visit it.
    if(right != null){
      RHeight = right.height(); // recursively increment
    }

    // find the greater value between LHeight and RHeight and return it + 1;
    if(LHeight > RHeight){
      return LHeight + 1;
    }else{
      return RHeight + 1;
    }

  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).

    //if the left node is not NULL, we visit it
    if(left != null){
      if( search < myValue){
        return left.depth(search) + 1;
      }
    }
    if(right != null){
      if(search > myValue){
        return right.depth(search) + 1;
      }
    }
    if(search == myValue){
      return 0;
    }

    return -1;
  }

  public int size(){
    // This method recursively calculates the size of the entire (sub)tree.
    int sum = 1; // sum is the variable which will store the tree's height.

    if(left != null){ // if the left node is not NULL, this means we can visit it.
      sum += left.size(); // increment sum recursively.
    }
    if(right != null){ // if the right node is not NULL, this means we can visit it.
      sum += right.size(); // increment sum recursively.
    }

    return sum;
  }
  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
