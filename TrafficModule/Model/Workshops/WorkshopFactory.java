package Model.Workshops;

import Model.Workshops.WorkshopTypes.VolvoWorkshop;

public class WorkshopFactory<T> {
    private Class<T> t;
    public T createWorkshop(Class<T> t) {
        T ws = new t();

        return ws;
    }
}
