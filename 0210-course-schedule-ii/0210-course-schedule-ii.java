class Solution {
    class node{
        int val;
        node next;
        node(int val,node next){
            this.val=val;
            this.next=next;
        }
    }
    class Graph{
        int vertices;
        node List[];
        Graph(int vertices){
            this.vertices=vertices;
            List=new node[vertices];
        }
    }
    public int DFS(Graph g,int i,int visited[],int out[],int index[],int path[]){
        if(visited[i]==1){
            if(path[i]==1)return 1;
            return 0;
        }
        visited[i]=1;
        path[i]=1;
        node temp=g.List[i];
        while(temp!=null){
            if(DFS(g,temp.val,visited,out,index,path)==1)return 1;
            temp=temp.next;
        }
        System.out.println(index[0]);
        path[i]=0;
        out[index[0]]=i;
        index[0]++;
        return 0;
    }
    public int[] findOrder(int num, int[][] edges) {
        Graph g=new Graph(num);
        for(int i=0;i<edges.length;i++){
            if(g.List[edges[i][0]]==null)g.List[edges[i][0]]=new node(edges[i][1],null);
            else{
                node newnode=new node(edges[i][1],null);
                newnode.next=g.List[edges[i][0]];
                g.List[edges[i][0]]=newnode;
            }  
        }

        int visited[]=new int[num];
        int out[]=new int [num];
        int path[]=new int [num];
        for(int i=0;i<num;i++){
            visited[i]=0;
            path[i]=0;
        }

        int index[]=new int[1];
        index[0]=0;

        for(int i=0;i<num;i++){
            if(visited[i]==0){
                if(DFS(g,i,visited,out,index,path)==1)return new int [0];
            }
        }
        return out;
    }
}