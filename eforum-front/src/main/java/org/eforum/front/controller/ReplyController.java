package org.eforum.front.controller;

import java.util.List;

import org.eforum.entity.Reply;
import org.eforum.produces.ResultJson;
import org.eforum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reply")
@RestController
public class ReplyController extends BaseController {
	@Autowired
	private ReplyService replyService;

	@RequestMapping("/commitReply")
	@Transactional
	public Object commitReply(@RequestParam(value = "articleId") Long articleId,
			@RequestParam(value = "replyContent") String replyContent) {
		replyService.commitReply(articleId, replyContent);
		return new ResultJson(true, "回复成功");
	}

	@RequestMapping("/getReplyByArticleId")
	@Transactional
	public Object getReplyByArticleId(@RequestParam(value = "articleId") Long articleId) {
		List<Reply> replys = replyService.getReplyByArticleId(articleId);
		return new ResultJson(true, replys);
	}

	@RequestMapping("/getReplyCountByArticleId")
	@Transactional
	public Object getReplyCountByArticleId(@RequestParam(value = "articleId") Long articleId) {
		Long replyCount = replyService.getReplyCountByArticleId(articleId);
		return new ResultJson(true, replyCount);
	}
}
