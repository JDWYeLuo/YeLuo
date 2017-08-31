package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.model.Mail;

public interface MailDao {

	List<BeanWork> findUser();

	void writeMail(Mail pe);

	int findMailCount(String mailKeyword, String mailFindname, BeanWork u);

	List<Mail> sendMailPage(int currentPage, String mailKeyword, String mailFindname, BeanWork u);

	int findReceiveMailCount(String receiveMailKeyWord, String receiveMailSearchField, BeanWork u);

	List<Mail> findReceiveMail(String receiveMailKeyWord, String receiveMailSearchField, int currentPage, BeanWork u);

	int findDraftMailCount(String draftMailKeyWord, String draftMailSearchField, BeanWork u);

	List<Mail> findDraftMail(String draftMailKeyWord, String draftMailSearchField, int currentPage, BeanWork u);

	int findTrashMailCount(String trashMailKeyWord, String trashMailSearchField, BeanWork u);

	List<Mail> findTrashMail(String trashMailKeyWord, String trashMailSearchField, int currentPage, BeanWork u);

	void changeMailStatus(String status, String id);

	void updateMail(Mail pe);

	Mail findMailById(String id);

}
