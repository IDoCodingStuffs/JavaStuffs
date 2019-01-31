# JavaStuffs

This repository is to showcase some handy projects (i.e stuffs) I have implemented in Java. Master branch holds
some of the highlights while specific branches showcase implementations grouped by purpose

### Showcased Stuffs

This branch showcases implementations using features introduced with Java EE 8, following along _Java
EE 8 Cookbook_ by Elder Moraes

#### Bean Validation

 This small recipe showcases bean validation annotations with a User model and some unit tests to
 see the results of adding the said annotations.

 ```
 @NotBlank
 private String name;

 @Email
 private String email;

 @NotEmpty
 private List<@PositiveOrZero Integer> profileId;
```

#### JsfStuffs

This recipe showcases implementing web interfaces using JavaServer Faces. It can be deployed on a server
like Glassfish to run.

```
<h:inputText id="userNameEmail"
             value="#{userBean.user}"
             converter="userConverter"
             validator="userValidator" />
```

#### JsonbStuffs

This recipe showcases two-way conversions between Java and JSON objects using JSON-B

```
 Jsonb jsonb = JsonbBuilder.create();
 String jsonUser = jsonb.toJson(user);
 User u = jsonb.fromJson(jsonUser, User.class);
```

#### JsonpStuffs

This recipe showcases extracting a given value from a JSON message using the JSON-P API

```
JsonStructure jsonStructure = jsonReader.read();
JsonPointer jsonPointer = Json.createPointer("/user/profile");
JsonValue jsonValue = jsonPointer.getValue(jsonStructure);
```

#### OrderedObservers

This recipe showcases adding event observers with CDI 2.0 that fire in an ordered fashion.

```
public void thisEventBefore(
      @Observes @Priority(Interceptor.Priority.APPLICATION - 200)
      StuffsEvent event
  ){
    System.out.println("thisEventBefore: " + event.getVal());
  }
```

#### SecurityAPI

This recipe showcases programmatically added user authorization for access to certain functionality.

```
@RolesAllowed({Roles.ADMIN, Roles.OPERATOR})
public void add(User user) {
  entityManager.persist(user);
}

@RolesAllowed({Roles.ADMIN})
public void remove(User user) {
  entityManager.remove(user);
}

@PermitAll
public List<User> get() {
  Query query = entityManager.createQuery("SELECT u FROM User as u");
  return query.getResultList();
}

```

#### ServerSentEvent_JAX-RS

This recipe showcases a simple JAX-RS implementation with a mock server periodically sending messages through
server-side events, which are one-way channels to the client, and a client consumer that receives them.

```
@GET
@Produces(MediaType.SERVER_SENT_EVENTS)
public void getMQ(@Context SseEventSink sink) {
  SseResorce.SINK = sink;
}
```

#### ServletStuffs

This recipe showcases a Servlet 4.0 implementation to load an image through Server Push

```
PushBuilder pushBuilder = request.newPushBuilder();

if (pushBuilder != null) {
  pushBuilder.path("images/javaee-logo.png")
     .addHeader("content-type", "image/png")
     .push();
}
```
