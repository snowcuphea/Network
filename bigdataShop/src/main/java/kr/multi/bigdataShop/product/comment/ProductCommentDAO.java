package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {

	int commentinsert(ProductCommentDTO comment);

	List<ProductCommentDTO> commentlist(String prdno);



}