package controllers;

import play.data.validation.Required;
import play.mvc.*;
import java.util.*;
import play.db.jpa.*;
import models.AEntry;
import models.Answer;
import models.KnowledgeBase;
import models.Question;
import models.User;
import models.Vote;

@With(Secure.class)
public class Application extends Controller {

	public static void index() {
		ArrayList<Question> questions = KnowledgeBase.getInstance()
				.getQuestions();
		User user = KnowledgeBase.getInstance().getCurrentUser();
		KnowledgeBase.getInstance().sortQuestions();

		render(questions, user);
	}

	public static void enterQuestion(String question) {
		KnowledgeBase.getInstance().getCurrentUser().putQuestion(question);
		KnowledgeBase.getInstance().sortQuestions();
		index();
	}

	public static void register(String name, String password) {
		KnowledgeBase.getInstance().createUser(name, password);
	}

	public static void questionDetail(int ID) {
		String question = "";
		Question ques;
		ArrayList<Answer> answers = new ArrayList<Answer>();
		int idNr = ID;

		for (Question q : KnowledgeBase.getInstance().getQuestions()) {
			if (q.ID == ID) {

				question = q.contents;
				answers = q.getAnswers();

			}
		}
		render(answers, question, idNr);
	}

	public static void upVote(int ID) {
		for (Question q : KnowledgeBase.getInstance().getQuestions()) {
			if (q.ID == ID
					&& KnowledgeBase.getInstance().getCurrentUser().id != q
							.getOwner().id) {
				for (Integer ident : q.getVoterIDs()) {
					if (ident != KnowledgeBase.getInstance().getCurrentUser().id) {
						q
								.vote(-1, KnowledgeBase.getInstance()
										.getCurrentUser().id);
					}

				}
				if (q.getVoterIDs().isEmpty()) {
					q.vote(1, KnowledgeBase.getInstance().getCurrentUser().id);
				}
			}

		}
		index();
	}

	/*public static void upVoteAnswer(int ID) {
		for (Question q : KnowledgeBase.getInstance().getQuestions()) {
			if (q.ID == ID) {
				for (Answer a : q.getAnswers()) {
					if (answerID == a.ID
							&& KnowledgeBase.getInstance().getCurrentUser().id != q
									.getOwner().id) {
						for (Integer ident : a.getVoterIDs()) {
							if (ident != KnowledgeBase.getInstance()
									.getCurrentUser().id) {

								a.vote(-1, KnowledgeBase.getInstance()
										.getCurrentUser().id);
							}

						}
					}
				
				if (a.getVoterIDs().isEmpty()) {
					
					q.vote(-1, KnowledgeBase.getInstance().getCurrentUser().id);
				}
				}
			}

		}
		questionDetail(ID);
	}
*/
	public static void downVote(int ID) {
		for (Question q : KnowledgeBase.getInstance().getQuestions()) {
			if (q.ID == ID
					&& KnowledgeBase.getInstance().getCurrentUser().id != q
							.getOwner().id) {
				for (Integer ident : q.getVoterIDs()) {
					if (ident != KnowledgeBase.getInstance().getCurrentUser().id) {
						q
								.vote(-1, KnowledgeBase.getInstance()
										.getCurrentUser().id);
					}

				}
				if (q.getVoterIDs().isEmpty()) {
					q.vote(-1, KnowledgeBase.getInstance().getCurrentUser().id);
				}
			}

		}
		index();
	}

	public static void reply(String answer, int idNr) {
		for (Question q : KnowledgeBase.getInstance().getQuestions()) {
			if (q.ID == idNr) {
				Answer a = new Answer(answer, KnowledgeBase.getInstance()
						.getCurrentUser(), q);

				q.answerQuestion(a);
			}
		}
		questionDetail(idNr);

	}

}