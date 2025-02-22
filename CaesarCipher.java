/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shifted = new char[26];
        shift = 1;
    }

    public CaesarCipher(int num){
        alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shifted = new char[26];
        shift = num;
        shifter(shift);
    }

    public String encrypt(String message){
        char str;
        int pos=0;
        String mess = "";
        for(int i=0; i<message.length(); i++){
            str = message.charAt(i);
            for(int p=0; p<alphabet.length; p++){
                if(str==alphabet[p]){
                    pos = p;
                    mess+=shifted[pos];
                    p=alphabet.length;
                }
                else if(p==alphabet.length-1 && str!=alphabet[p]){
                    mess+=message.substring(i,i+1);
                }
    
            }
        }
            
        
        return "" + mess;
    }

    public String decrypt(String message){
        char str;
        int pos=0;
        String mess = "";
        for(int i=0; i<message.length(); i++){
            str = message.charAt(i);
            for(int p=0; p<shifted.length; p++){
                if(str==shifted[p]){
                    pos = p;
                    mess+=alphabet[pos];
                    p=shifted.length;
                }
                else if(p==shifted.length-1 && str!=shifted[p]){
                    mess+=message.substring(i,i+1);
                }

            }
            
        }
        return "" + mess;
    }

    public void shifter(int num){
        shifted = new char[26];
        for(int i=0; i<alphabet.length;i++){
            shifted[(i+num)%26] = alphabet[i];
        }
    }


}