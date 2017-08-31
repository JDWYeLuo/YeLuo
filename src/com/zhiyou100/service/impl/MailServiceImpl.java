package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.MailDao;
import com.zhiyou100.dao.impl.MailDaoImpl;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.model.Mail;
import com.zhiyou100.service.MailService;

public class MailServiceImpl implements MailService {
	MailDao md ;
	

	public MailDao getMd() {
		return md;
	}

	public void setMd(MailDao md) {
		this.md = md;
	}

	@Override
	public List<BeanWork> findUser() {
		
		return md.findUser();
	}

	@Override
	public void writeMail(Mail pe) {
		md.writeMail( pe);	
	}

	@Override
	public int findMailCount(String mailKeyword, String mailFindname, BeanWork u) {
		
		return md.findMailCount(mailKeyword,mailFindname,u);
	}

	@Override
	public List<Mail> sendMailPage(int currentPage, String mailKeyword, String mailFindname, BeanWork u) {
		
		return md.sendMailPage( currentPage,  mailKeyword,  mailFindname,u);
	}

	@Override
	public int findReceiveMailCount(String receiveMailKeyWord, String receiveMailSearchField, BeanWork u) {
		
		return md.findReceiveMailCount( receiveMailKeyWord,  receiveMailSearchField,  u);
	}

	@Override
	public List<Mail> findReceiveMail(String receiveMailKeyWord, String receiveMailSearchField, int currentPage,
			BeanWork u) {
		
		return md.findReceiveMail( receiveMailKeyWord,  receiveMailSearchField,  currentPage, u);
	}

	@Override
	public int findDraftMailCount(String draftMailKeyWord, String draftMailSearchField, BeanWork u) {
		
		return md.findDraftMailCount( draftMailKeyWord,  draftMailSearchField,  u);
	}

	@Override
	public List<Mail> findDraftMail(String draftMailKeyWord, String draftMailSearchField, int currentPage, BeanWork u) {
		
		return md.findDraftMail( draftMailKeyWord,  draftMailSearchField,  currentPage,  u);
	}

	@Override
	public int findTrashMailCount(String trashMailKeyWord, String trashMailSearchField, BeanWork u) {
		
		return md.findTrashMailCount( trashMailKeyWord,  trashMailSearchField,  u);
	}

	@Override
	public List<Mail> findTrashMail(String trashMailKeyWord, String trashMailSearchField, int currentPage, BeanWork u) {
		
		return md.findTrashMail( trashMailKeyWord,  trashMailSearchField,  currentPage,  u);
	}

	@Override
	public void changeMailStatus(String status, String id) {
		md.changeMailStatus( status,  id);
		
	}

	@Override
	public void updateMail(Mail pe) {
		md.updateMail( pe);
		
	}

	@Override
	public Mail findMailById(String id) {
		
		return md.findMailById( id);
	}
}
