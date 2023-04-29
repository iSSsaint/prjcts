package ma.ac.emi.ginfo.gestionlogiciels.services;

import ma.ac.emi.ginfo.gestionlogiciels.entities.Compte;
import ma.ac.emi.ginfo.gestionlogiciels.repositories.CompteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final CompteRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(CompteRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void signUpUser(Compte user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    public List<Compte> getCompteList() {
        return userRepository.findAll();
    }

}
