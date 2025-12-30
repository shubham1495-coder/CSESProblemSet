package Range_Queries;
import java.util.*;
import java.io.*;

public class Segment_Tree {

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int[] arr, int n){
            this.n = n;
            tree = new int[4 * n];
            build(1, 1, n, arr);
            print();
        }
        void print(){
            for(int i = 0; i < 4 * n; i++){
                System.out.print(tree[i] + " ");
            }
        }

        void build(int node, int l, int r, int[] arr){
            if(l == r){
                tree[node] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(node*2, l, mid, arr);
            build(node*2+1, mid+1, r, arr);
            tree[node] = tree[node*2] + tree[node*2+1];
        }

        void update(int node, int l, int r, int idx, int val){
            if(l == r){
                tree[node] = val;
                return;
            }
            int mid = (l + r) / 2;
            if(idx <= mid) update(node*2, l, mid, idx, val);
            else update(node*2+1, mid+1, r, idx, val);
            tree[node] = tree[node*2] + tree[node*2+1];
        }

        int query(int node, int l, int r, int ql, int qr){
            if(qr < l || ql > r) return 0;
            if(ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return query(node*2, l, mid, ql, qr) +
                    query(node*2+1, mid+1, r, ql, qr);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = s.nextInt();
        }

        SegmentTree st = new SegmentTree(arr, n);

        while(m-- > 0){
            int type = s.nextInt();
            if(type == 1){
                int pos = s.nextInt();
                int value = s.nextInt();
                st.update(1, 1, n, pos, value);
            } else {
                int l = s.nextInt();
                int r = s.nextInt();
                System.out.println(st.query(1, 1, n, l, r));
            }
        }
    }
}
