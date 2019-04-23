package model;

public interface Obserwowany {
    public void subscribe( Obserwator o );
    public void unsubscribe( Obserwator o );
    public void informAll();
}
