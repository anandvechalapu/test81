
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/forgotpassword/{email}")
    public void forgotPassword(@PathVariable String email) {
        userService.forgotPassword(email);
    }

    @PutMapping("/resetpassword/{email}")
    public void resetPassword(@PathVariable String email, @RequestBody String newPassword) {
        userService.resetPassword(email, newPassword);
    }
}

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void forgotPassword(String email) {
        // code to send mail to the user
    }

    public void resetPassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(newPassword);
            userRepository.save(user);
        }
    }
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}