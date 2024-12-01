package factory;

public interface Factory<T> {
    T criar(String tipo);
}
