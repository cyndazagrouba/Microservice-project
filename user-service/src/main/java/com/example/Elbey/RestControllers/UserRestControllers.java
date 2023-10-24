package com.example.Elbey.RestControllers;

import com.example.Elbey.DAO.Entities.User;
import com.example.Elbey.DAO.Repositories.UserRepository;
import com.example.Elbey.Service.Interfaces.IUser;
import lombok.AllArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin("*")
public class UserRestControllers {
    private String title = "Hello, I'm the candidate Microservice";
    private IUser iUser;
    @Autowired
    UserRepository userRepository;

    ////////

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }
    @PostMapping
    @RequestMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user, KeycloakAuthenticationToken auth) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");
userRepository.save(user);
        if (hasUserRole) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(iUser.edit(user), HttpStatus.OK);
    }
    @DeleteMapping(value = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id, KeycloakAuthenticationToken auth){
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("admin");
        userRepository.deleteById(id);
        if (hasUserRole) {
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    ///////




    @GetMapping("/admin/afficheruser")
    public List<User> afficher()
    {
        return iUser.selectAll();
    }
    public boolean hasEightDigits(Long number) {
        return (number >= 10000000L && number <= 99999999L);//La première condition vérifie si "number" est supérieur ou égal à 10^7 (ce qui correspond à un nombre à 8 chiffres ou plus).
        //La deuxième condition vérifie si "number" est inférieur ou égal à 10^8 - 1 (ce qui correspond à un nombre à 8 chiffres ou moins).
    }
    @GetMapping("/roles")
    public String[] getRoles() {
        // Récupérer l'objet d'authentification à partir du contexte de sécurité
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Récupérer les rôles de l'utilisateur à partir de l'objet d'authentification
        String[] roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new);

        return roles;
    }
    @PostMapping("/ajouteruser")

    public ResponseEntity<String> ajouter(@RequestBody User user)
    {   boolean testMotdepasse=user.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+~`|}{\\[\\]\\\\:;'<>,.?/\\-])[A-Za-z0-9!@#$%^&*()_+~`|}{\\[\\]\\\\:;'<>,.?/\\-]{8,}$");
        boolean test = hasEightDigits(user.getPhone());
        boolean testCin = hasEightDigits(user.getCin());
        if(!test)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le numèro de téléphone doit contenir 8 chiffres");
        } else if (!testCin) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le numèro de CIN doit contenir 8 chiffres");

        } else if (!user.getEmail().matches("^.+@.+\\..+$")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("un problème au niveau de saise du mail");

        } else if (!user.getVerifPassword().matches(user.getPassword()) || !testMotdepasse) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("verifiez le mot de passe ");

        }
        else
            //(user.getEmail().matches("^.+@.+\\..+$") && user.getVerifPassword().matches(user.getPassword()) && test==true )
        {iUser.add(user);

        return  ResponseEntity.status(HttpStatus.OK).body("ajout done");
        }


    }
    @PutMapping("/user/updateuser")
    public User update(@RequestBody User user)
    {return iUser.edit(user);
    }
    @GetMapping("/afficherUserbyID/{id}")
    public User AfficherByID(@PathVariable int id)
    {
        return iUser.SelectById(id);
    }
    @GetMapping("/AfficherUserByemail/{email}")
    public User AfficherByemail(@PathVariable String email)
    {
        return iUser.getUserByEmail(email);
    }
    @DeleteMapping("/admin/deleteUserbyID/{id}")
    public void delete(@PathVariable int id)
    {
        iUser.deleteById(id);
    }


    @PutMapping("/user/updateuser/{id}")
    public void updateuserbyID(@PathVariable String id,@RequestBody User user)
    {
        User u=iUser.getUserByEmail(id);
        u.setFirstName(user.getFirstName());
        u.setLasttName(user.getLasttName());
        u.setCin(user.getCin());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setProfession(user.getProfession());
        iUser.edit(u);
    }

}
