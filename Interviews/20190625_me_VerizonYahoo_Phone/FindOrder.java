FindOrder

Give a packages and dependencies. Find out in which order packages can be installed so that we can install package A successfully. 
A -> B, C, D, E
C -> F, G, E
D -> H, F
E -> H, F
G -> H

stack -> 

result -> B, F, H

visited -> A, B, C, F, G, H, 


dfs(A) -> 
  dfs(B) -> 
  dfs(C) -> 
    dfs(F) -> 
    dfs(G) -> 
       dfs(H) ->


public class Node {

  public String name;
  public Boolean visited;
  public List<Node> children;

}


class Graph{
  public Node root;
   
}

class FindOrder{


    public List<Node> findOrder(Graph g){
    
        if (g.root == null) {
          return null;
        }
        List<Node> re = new ArrayList<>();
        dfs(g.root, re);
        return re;
    }
    
    void dfs(Node root, List<Node> re){
            if(root != null && root.visited != True ){DB 
                 root.visited = True;
                 int i = 0;
                 while (i < root.children.size()){
                     dfs(root.chidren[i], re);
                     i++;
                 }
                 re.add(root);
            }
        }
    }    
}
    
    



