package socialmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String viewPosts(Model model) {
        // Fetch all posts and display them
        model.addAttribute("posts", postRepository.findAll());
        return "posts"; // Corresponds to posts.html
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String content) {
        // Allow users to add posts without needing a user
        Post post = new Post();
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        return "redirect:/posts";
    }
}
