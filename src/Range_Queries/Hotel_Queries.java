package Range_Queries;
import java.util.*;
public class Hotel_Queries {

    static class hotel{
        int n;
        int[] tree;
        hotel(int[] arr){
            n = arr.length-1;
            tree = new int[4*n];
            build(1,1,n,arr);
        }

        void build(int node,int l , int r , int[] arr){
            if(l==r){
                tree[node] = arr[l];
                return;
            }
            int mid = (l+r)/2;
            build(node*2, l, mid, arr);
            build(node*2+1, mid+1, r, arr);
            tree[node] = Math.max(tree[node*2],tree[node*2+1]);
        }



        void update(int node, int l, int r , int pos, int val){
            if(l==r){
                tree[node] = val;
                return;
            }
            int mid = (l+r)/2;
            if(pos<=mid) update(node*2,l,mid,pos,val);
            else update(node*2+1,mid+1,r,pos,val);
            tree[node] = Math.max(tree[node*2],tree[node*2+1]);
        }

        int findfirst(int node,int l,int r, int tar){
            if(tree[node]<tar) return -1;
            if(l==r){
                return l;
            }
            int mid = (l+r)/2;
            if(tree[node*2]>=tar) return findfirst(node*2,l,mid,tar);
            else return findfirst(node*2+1,mid+1,r,tar);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = s.nextInt();
        }
        hotel h = new hotel(arr);
        while(q-->0){
            int target = s.nextInt();
            int position = h.findfirst(1,1,n,target);
            if(position==-1){
                System.out.println(0);
            }else{
                System.out.println(position);
                arr[position] -= target;
                h.update(1,1,n,position,arr[position]);
            }
        }
    }

}
