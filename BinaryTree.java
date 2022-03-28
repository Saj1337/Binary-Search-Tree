import java.util.Scanner;

class BinaryTree {
    
    Node root;
    
    class Node {
        
        int data;
        Node Lchild;
        Node Rchild;

        public Node(int data) {
            this.data = data;
            Lchild = null;
            Rchild = null;
        }
    }
    
    public Node insert(Node current, int data) {
        if (current == null) {
            return new Node(data);
        } else if (data < current.data) {
            current.Lchild = insert(current.Lchild, data);
        } else if (data > current.data) {
            current.Rchild = insert(current.Rchild, data);
        }

        return current;
    }
    
    public void add(int data) {
        root = insert(root, data);
 
    }
    
    public void deleteKey(int data) { 
        root = delete_Recursive(root, data); 
    } 

    Node delete_Recursive(Node root, int key)  { 
        if (root == null)  return root; 
   

        if (key < root.data)    
            root.Lchild = delete_Recursive(root.Lchild, key); 
        else if (key > root.data)  
            root.Rchild = delete_Recursive(root.Rchild, key); 
        else  { 

            if (root.Lchild == null) 
                return root.Rchild; 
            else if (root.Rchild == null) 
                return root.Lchild; 
   
            root.data = minValue(root.Rchild); 
   
            root.Rchild = delete_Recursive(root.Rchild, root.data); 
        } 
        return root; 
    }
    
    int minValue(Node root)  { 
 
        int minval = root.data; 
  
        while (root.Lchild != null)  { 
            minval = root.Lchild.data; 
            root = root.Lchild; 
        } 
        return minval; 
    } 

    void inorder(Node current) {
        if (current != null) {
            inorder(current.Lchild);
            System.out.println(current.data);
            inorder(current.Rchild);
        }
    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.add(8);
        bTree.add(3);
        bTree.add(1);
        bTree.add(6);
        bTree.add(7);
        bTree.add(10);
        bTree.add(14);
        bTree.add(4);
        bTree.inorder(bTree.root);
        System.out.println("Deleting node 10 from tree...");
        bTree.deleteKey(10);
        bTree.inorder(bTree.root);
    }
}
