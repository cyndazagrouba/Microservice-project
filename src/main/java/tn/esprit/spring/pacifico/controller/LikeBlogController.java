package tn.esprit.spring.pacifico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.entities.LikeBlog;
import tn.esprit.spring.pacifico.repository.BlogRepository;
import tn.esprit.spring.pacifico.service.LikeBlogService;
import tn.esprit.spring.pacifico.dto.LikeBlogDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/likeBlog")
public class LikeBlogController {

    @Autowired
    LikeBlogService likeBlogService ;
   /* @Autowired
    UserRepository userRepository ;
  */  @Autowired
    BlogRepository blogRepository ;

  /*  @PostMapping("/add-like")
    @ResponseBody
    public String addLike(@RequestBody @Valid LikeBlogDto  likeBlogDto)
    {
        return likeBlogService.addLike(likeBlogDto);
    }*/


/*


    @RequestMapping(method=RequestMethod.PUT,value="/addDislike/{Idblog}/{Iduser}")
    public String addDislike(@PathVariable("Iduser") Long  Iduser,@PathVariable("Idblog") Long  Idblog,@RequestBody @Valid LikeBlog likeBlog)
    {
        return likeBlogService.addDislike(Iduser,Idblog,likeBlog);
    }


  */
/*  @RequestMapping(method=RequestMethod.PUT,value="/addLike/{Idblog}/{etat}/{Iduser}")
    public String addlike(@PathVariable("Iduser") Long  Iduser,@PathVariable("Idblog") Long  Idblog,@PathVariable boolean  etat){
        User us=  userRepository.findAllByIdUser(Iduser);
        Blog blog = blogRepository.findById(Idblog).get();
        LikeBlog likeBlog = new LikeBlog();
        likeBlog.setUser(us);
        likeBlog.setBlogg(blog);
        likeBlog.setEtat(etat);
        if(etat==true)
        {

            return	likeBlogService.addLike( Iduser, Idblog, likeBlog);
        }
        else
            return likeBlogService.addDislike(Iduser, Idblog, likeBlog);

    }*//*




    @DeleteMapping("/removelike/{Idblog}/{Iduser}")
    public String deleteLike(@PathVariable("Idblog") Long Idblog,@PathVariable("Iduser") Long Iduser) {


      return   likeBlogService.deleteLike(Iduser,Idblog);
    }

    @DeleteMapping("/remove-like/{id}")
    public void deletePubLike(@PathVariable("id")Long id){


        likeBlogService.deletePubLike(id);
    }

    @GetMapping(value ="/nblikes/{Idblog}")
    @ResponseBody
    public int getNblikes(@PathVariable("Idblog") Long Idblog)
    {return likeBlogService.nbLike(Idblog);}



    @GetMapping(value ="/nbdislikes/{Idblog}")
    @ResponseBody
    public int getNbdislikes(@PathVariable("Idblog") Long Idblog)
    {

        return likeBlogService.nbdisLike(Idblog);

    }
*/

}
