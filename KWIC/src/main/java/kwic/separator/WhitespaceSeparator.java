package kwic.separator;

class WhitespaceSeparator extends Separator{
    @Override
    public String[] separate(String str){
        return str.split(" ");
    }
}
