public enum Alphabet {
    a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    public static int getNum(String target) {
        return valueOf(target).ordinal();
    }

    // Option for char input, first converts to String
    public static int getNum(char target) {
        return valueOf(String.valueOf(target)).ordinal();
    }
}
