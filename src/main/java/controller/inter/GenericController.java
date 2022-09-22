package controller.inter;

import java.util.List;

public interface GenericController <T, L, S> {
    S createFromDTO(T t);
    List<T> getAllToDTO();
    T getByIdToDTO(L id);
    S updateFromDTO(T t);
    void deleteFromId (L id);
}
