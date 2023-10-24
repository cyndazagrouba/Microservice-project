package tn.esprit.spring.pacifico.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.entities.LikeBlog;
import tn.esprit.spring.pacifico.repository.LikeBlogRepository;
import tn.esprit.spring.pacifico.dto.LikeBlogDto;

import java.util.List;

@Service
@Transactional
public class LikeBlogService implements ILikeBlogService{

     @Autowired
   private LikeBlogRepository likeBlogRepository;
     @Autowired
    ModelMapper modelMapper;

/*

*/
/*    @Override
    public String addLike(LikeBlogDto likeBlogDto) {
        LikeBlog like = modelMapper.map(likeBlogDto, LikeBlog.class);
        User user =new User();
        Blog blog = new Blog();
        user.setIdUser(likeBlogDto.getIduser());
        blog.setIdBlog(likeBlogDto.getIdblog());
        like.setUser(user);
        like.setBlogg(blog);
        List<LikeBlog> like1;
        like1=likeBlogRepository.findAll();
     //   like1=likeBlogRepository.likeexist(blog.getIdBlog(), user.getIdUser());
        for (LikeBlog la : like1)
        {
            if (likeBlogDto.getIdblog().equals(la.getBlogg().getIdBlog() ) &&
                    likeBlogDto.getIduser().equals(la.getUser().getIdUser()) &&
                    likeBlogDto.isEtat() == la.isEtat())
            {

                return "user a déjà aimé cette publication";
            }
        }
        modelMapper.map(like1, LikeBlogDto.class);
        likeBlogRepository.save(like);
        return "like enregistré";
    }*//*




    */
/*    @Override
        public String addLike(Long Iduser,Long Idblog,LikeBlogDto likeBlogDto){
            LikeBlog likeBlog = modelMapper.map(likeBlogDto, LikeBlog.class);

            if (likeBlogDto == null )
            {
                likeBlogRepository.save(likeBlog);
                return "save with success";
            }
            else if (likeBlogDto.isEtat() == false)
            {
                likeBlogRepository.save(likeBlog);
            }
            modelMapper.map(likeBlog, LikeBlogDto.class);
            return "update with success";
        }



     *//*

*/
/*
public String addDislike(Long Iduser,Long Idblog,LikeBlog likeBlog){
    LikeBlog la= new LikeBlog();
    la=likeBlogRepository.likeexist(Iduser, Idblog);
    if (la==null){
        likeBlogRepository.save(likeBlog);
        return "save with succes";
    }
    else if(la.isEtat()==true){
        la.setEtat(false);
        likeBlogRepository.save(la);
    }
    return "update with succes";
}
*//*



*/
/*    public String addLike(Long iduser,Long idad,LikeBlog likeBlog){
        LikeBlog la= new LikeBlog();
        la=likeBlogRepository.likeexist(iduser, idad);
        if (la==null)
        {
            likeBlogRepository.save(likeBlog);
            return "save with succes";
        }
        else if(la.isEtat()==false){
            la.setEtat(true);
            likeBlogRepository.save(la);
        }
        return "update with succes";
    }*//*



*/
/*
    @Override
    public String addDislike(Long Iduser, Long Idblog, LikeBlogDto likeBlogDto)
    {
    LikeBlog like = modelMapper.map(likeBlogDto, LikeBlog.class);
        like=likeBlogRepository.likeexist(Iduser, Idblog);
        if (like==null){
            like =likeBlogRepository.save(like);

            return "save with succes";
        }
        else if(like.isEtat()==true){
            like.setEtat(false);
            like =likeBlogRepository.save(like);
        }
        return "update with succes";
    }


    @Override
    public String addDislike(Long Iduser, Long Idblog, LikeBlogDto likeBlogDto) {

        LikeBlog likeBlog = modelMapper.map(likeBlogDto, LikeBlog.class);
      //  LikeBlog l = likeBlogRepository.likeexist(Iduser, Idblog);
        if (likeBlogDto == null)
        {
            likeBlogRepository.save(likeBlog);
            return "save with success";
        } else if (likeBlogDto.isEtat() == true)
        {
            likeBlogDto.setEtat(false);
            modelMapper.map(likeBlog, likeBlogDto);
            likeBlogRepository.save(likeBlog);
            return "update with success";
        }

        return "no update necessary";
    }



*//*




    @Override
    public List<LikeBlog> retrieveAllLike() {
        List<LikeBlog> likes = (List<LikeBlog>) likeBlogRepository.findAll();
		*/
/*for (LikeAdd like : likes) {
			L.info("user +++ : " + like);
		}*//*

        return likes;
    }

    @Override
    public String updateLike(Long id, boolean etat) {
        LikeBlogDto likeBlogDto =new LikeBlogDto();
        LikeBlog like = modelMapper.map(likeBlogDto, LikeBlog.class);
        like= likeBlogRepository.findAllById(id);

        like.setEtat(etat);

        likeBlogRepository.save(like);
        return "react updated";
    }

    @Override
    public int nbLike(Long Idblog) {
        return likeBlogRepository.nbLike(Idblog);
    }
    @Override
    public int nbdisLike(Long Idblog) {
        return likeBlogRepository.nbDisLike(Idblog);
    }

    @Override
    public void deletePubLike(Long id) {likeBlogRepository.deleteById(id);}

    @Override
    public String deleteLike(Long Iduser, Long Idblog) {

        LikeBlogDto likeBlogDto = new LikeBlogDto();
        LikeBlog la = modelMapper.map(likeBlogDto, LikeBlog.class);
    la=  likeBlogRepository.likeexist(Iduser, Idblog);
        if (likeBlogDto==null)
        {

            return "add doesn't exist";
        }
        else {

            likeBlogRepository.delete(la);
        }
        modelMapper.map(la, LikeBlogDto.class);
        return "deletion with succes";
    }








*/









    /*
    @Override
    public String addLike(LikeBlogDto likeBlogDto) {
        ModelMapper modelMapper = new ModelMapper();
        LikeBlog like = modelMapper.map(likeBlogDto, LikeBlog.class);
        List<LikeBlog> like1 =new ArrayList<LikeBlog>();
        like1=likeBlogRepository.findAll();


        for( LikeBlog la : like1)
        {
            if (like.getBlog().getIdBlog()==la.getBlog().getIdBlog() &&
                    (like.getUser().getIdUser().equals(la.getUser().getIdUser() ) )
                    && like.isEtat()==la.isEtat())
            // throw new RuntimeException("You can't cancel these !");
            {
                return "user a déja aimé cette blog";
            }
            else
            {
                likeBlogRepository.save(like);
            }
        }
        return "like enregistré";


    }
    @Override
    public String addLike(Long Iduser, Long Idblog, LikeBlogDto likeBlogDto){
       LikeBlog likeBlog = modelMapper.map(likeBlogDto,LikeBlog.class);
       // LikeAdd la= new LikeAdd();
        likeBlog=likeBlogRepository.likeexist(Iduser, Idblog);
        if (likeBlog==null)
        {
            likeBlogRepository.save(likeBlog);
            return "save with succes";
        }
        else if(likeBlog.isEtat()==false){
            likeBlog.setEtat(true);
            likeBlogRepository.save(likeBlog);
        }
        return "update with succes";
    }
    @Override
    public String addDislike(Long Iduser,Long Idblog,LikeBlogDto likeBlogDto){
   LikeBlog likeBlog =modelMapper.map(likeBlogDto,LikeBlog.class);
     //   LikeAdd la= new LikeAdd();
        likeBlog =likeBlogRepository.likeexist(Iduser, Idblog);
        if (likeBlog==null){
            likeBlogRepository.save(likeBlog);
            return "save with succes";
        }
        else if(likeBlog.isEtat()==true){
            likeBlog.setEtat(false);
            likeBlogRepository.save(likeBlog);
        }
        return "update with succes";
    }

    /*
    public String addLike(LikeBlogDto likeDTO) {
        LikeBlog likeBlog = likeBlogRepository.findById(likeDTO.getId()).orElse(null);
        if (likeBlog == null) {
            likeBlog = modelMapper.map(likeDTO, LikeBlog.class);
            likeBlogRepository.save(likeBlog);
            return "like enregistré";
        } else if (!likeBlog.isEtat()) {
            likeBlog.setEtat(true);
            likeBlogRepository.save(likeBlog);
            return "update with success";
        }
        return "user a déjà aimé cette pub";
    }
     */
   /*
    public String addLike(Long userId, Long blogId, LikeBlogDto likeDTO) {
        LikeBlog likeAdd = likeBlogRepository.likeexist(userId, blogId);
        if (likeAdd == null) {
            likeAdd = modelMapper.map(likeDTO, LikeBlog.class);
            likeBlogRepository.save(likeAdd);
            return "save with success";
        } else if (!likeAdd.isEtat()) {
            likeAdd.setEtat(true);
            likeBlogRepository.save(likeAdd);
            return "update with success";
        }
        return "user a déjà aimé cette pub";
    }
    */


/*


        for( LikeBlog la : like1)
        {
            if (likeBlogDto.getIdblog()==likeBlogDto.getIdblog() && (likeBlogDto.getIduser().equals(la.getUser().getIdUser() ) ) &&
                    likeBlogDto.isEtat()==la.isEtat())
            // throw new RuntimeException("You can't cancel these !");
            {

                return "user a déja aimé cette pub";
            }

            else

            {
                modelMapper.map(like1, BlogDto.class);

            }
        }

 */


}