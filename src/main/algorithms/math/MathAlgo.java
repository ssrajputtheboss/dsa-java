package main.algorithms.math;

public class MathAlgo {
    public static long pow(long x, long n){
        long ret = 1;
        while(n  > 0){
            if((n&1)==1){
                ret = ret *x;
            }
            x = x*x;
            n/=2;
        }
        return ret;
    }

    public static long powMod(long x, long n, long mod){
        long ret = 1;
        while(n  > 0){
            if((n&1)==1){
                ret = ret *x % mod;
            }
            x = x*x % mod;
            n/=2;
        }
        return ret%mod;
    }
    public static long modInverse(long x , long mod){
        return powMod(x,mod-2,mod);
    }

    public static long modInvEuclidean(long x, long mod){
        long[] l = extendedEuclidean(x,mod);
        return l[0] == -1 ? -1 : (l[1]%mod+mod)%mod;
    }

    public static long gcd(long a, long b){
        if(b == 0)return a;
        else return gcd(b , a%b);
    }
    public static long[] extendedEuclidean(long a, long b){
        long x =1, y=0;
        long x1 = 0,y1=1,a1=a,b1=b, tmp;
        while (b1!=0){
            long q = a1/b1;
            tmp = x - q*x1;
            x = x1;
            x1 = tmp;

            tmp = y - q*y1;
            y=y1;
            y1=tmp;

            tmp = a1 - q*b1;
            a1=b1;
            b1=tmp;
        }
        return new long[]{a1,x,y};
    }

    public static long totient(long n){
        long result = n;
        for(long x=2;x*x<=n;++x){
            if(n%x==0){
                while (n%x==0){
                    n/=x;
                }
                result -= result/x;
            }
        }
        if (n>1){
            result -= result/n;
        }
        return result;
    }

    public static long[] totient_range(int range){
        long[] phis = new long[range+1];
        phis[0]=0;
        phis[1]=1;
        for(int i=2;i<=range;++i)
            phis[i]=i-1;
        for(int i=2;i<=range;++i){
            for(int j=2*i;j<=range;j+=i){
                phis[j]-=phis[i];
            }
        }
        return phis;
    }

    public static long crt(long[][] a){
        int n = a.length;
        // m == 2 always
       long M = 1;
       for (long[] longs : a) M *= longs[1];
       long ans = 0;
       for(int i=0;i<n;++i){
           long mi = M/a[i][1];
           long ni = modInvEuclidean(mi,a[i][1]);
           long mini = (mi*ni)%M;
           ans = (ans + (a[i][0]*mini)%M)%M;
       }
       return ans;
    }

    /*
    k = no of prime number limit
    r[][] = r[i][j] = p[i]^-1 % p[j]
    x [] = x[i] of garner's radix representation (calculated in function)
    a [] = a[i] of garner's
    p [] = p[i] i 'th prime number
     */
    public static int[] garner(int k , int[][] r, int[] x, int[] a, int[] p){
        for (int i = 0; i < k; ++i) {
            x[i] = a[i];
            for (int j = 0; j < i; ++j) {
                x[i] = r[j][i] * (x[i] - x[j]);

                x[i] = x[i] % p[i];
                if (x[i] < 0)
                    x[i] += p[i];
            }
        }
    return x;
    }

    public static long fact(long x){
        long ret=1;
        while (x > 1)
            ret*=x--;
        return ret;
    }

    // wilson's theorem (p-1)!%p=-1 for p = prime
    public static int factMod(long x, int mod){
        int[] f = new int[mod];
        f[0]=f[1]=1;
        for(int i=2;i<mod;++i){
            f[i] = f[i-1] * i %mod;
        }
        long ans = 1;
        long m = mod;
        while (x > 1){
            if(((x/m)&1)==0){
                ans = m - x;
            }
            ans = (ans*f[(int)(x%m)])%m;
            x/=mod;
        }
        return (int)ans;
    }

    public static int grayCode(int x){
        return x ^ (x >> 1);
    }

    public static int revGrayCode(int g){
        int x = 0;
        while (g!=0){
            x ^= g;
            g = g>>1;
        }
        return x;
    }
    public static long ncr(long n, long r){
        long num = 1,den = 1;
        long mn = Math.min(r,n-r) , mx = Math.max(r,n-r);
        while (n > mx)num*=n--;
        while (mn>1)den*=mn--;
        return num/den;
    }
    // n'th catalan
    public static long catalan(int n){
        return ncr(2L *n , n) / (n+1);
    }

    // n catalan numbers
    public static long[] catalan_seq(int n){
        if(n<2)return new long[]{1};
        long[] c = new long[n+1];
        c[0]=c[1]=1; // default 0
        for(int i=2;i<=n;++i){
            for(int j=0;j<i;++j){
                c[i] += c[j] * c[i-j-1];
            }
        }
        return c;
    }

}
