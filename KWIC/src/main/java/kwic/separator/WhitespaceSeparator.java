package kwic.separator;

class WhitespaceSeparator implements Separator{
    @Override
    public String[] separate(String str){
        return str.split(" ");
    }
}
