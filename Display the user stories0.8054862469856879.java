

Generate Spring Boot application with controller, service and repository classes:

Controller:

@Controller
public class UserStoryController {
 
    @Autowired
    private UserStoryService userStoryService;
 
    @GetMapping("/user-stories")
    public ResponseEntity<?> getUserStories() {
        List<UserStory> userStories = userStoryService.getUserStories();
        return ResponseEntity.ok(userStories);
    }
}

Service:

@Service
public class UserStoryService {
 
    @Autowired
    private UserStoryRepository userStoryRepository;
 
    public List<UserStory> getUserStories() {
        return userStoryRepository.findAll();
    }
}

Repository:

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
 
}