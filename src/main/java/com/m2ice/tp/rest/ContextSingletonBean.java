package com.m2ice.tp.rest;

import com.m2ice.tp.rest.models.Done;
import com.m2ice.tp.rest.models.Service;
import com.m2ice.tp.rest.models.User;

import javax.ejb.Singleton;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Singleton
public class ContextSingletonBean {

    private final List<User> users;

    private int counterUser = 1;
    private int counterService = 1;
    private int counterServiceDone = 1;

    public ContextSingletonBean() {
        this.users = new ArrayList<>();
        User user = new User(0, "montal");
        Service service = new Service(0, "jardin", 2);
        service.getDones().add(new Done(0, "1" , "3"));
        user.getServices().add(service);

        this.users.add(user);

    }

    public List<User> getUsers() {
        return users;
    }

    public int addUser(User user) throws ServerErrorException {
        user.setId(counterUser);
        counterUser++;
        this.users.add(user);
        return user.getId();
    }

    public User getUser(int id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst()
                .orElseThrow(() -> new WebApplicationException(Response.Status.FORBIDDEN));
    }

    public int addUserService(int id, Service service) {
        service.setId(counterService);
        counterService++;
        this.getUser(id).getServices().add(service);
        return service.getId();
    }

    public Service getUserService(int id, int idService) {
        return this.getUser(id).getServices().stream().filter(service -> service.getId() == idService).findFirst()
                .orElseThrow(() -> new WebApplicationException(Response.Status.FORBIDDEN));
    }

    public int addUserServiceDone(int id, int idService, Done done) {
        done.setId(counterServiceDone);
        counterServiceDone++;
        this.getUserService(id, idService).getDones().add(done);
        return done.getId();
    }

    public Done getUserServiceDone(int id, int idService, int idDone) {
        return this.getUserService(id, idService).getDones().stream().filter(done -> done.getId() == idDone).findFirst()
                .orElseThrow(() -> new WebApplicationException(Response.Status.FORBIDDEN));
    }

}
