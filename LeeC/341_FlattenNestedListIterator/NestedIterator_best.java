


public class NestedIterator implements Iterator<Integer> {

    List<Integer> result = new ArrayList<>();
    
    private Iterator<Integer> it;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        
        flattenList(nestedList);
        it = result.iterator();
        
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
    
    private void flattenList(List<NestedInteger> list){
        
        for (NestedInteger ni: list) {
            
            if(ni.isInteger()){
                result.add(ni.getInteger());
            } else {
                flattenList(ni.getList());
            }
            
        }
        
    }

    public static void main(String args[]){


    }
    
}

