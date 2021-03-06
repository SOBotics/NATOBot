package in.bhargavrao.stackoverflow.natty.validators;

import in.bhargavrao.stackoverflow.natty.model.Post;

/**
 * Created by bhargav.h on 11-Sep-16.
 */
public class RPublicValidator implements Validator {

    @Override
    public boolean validate(Post post) {
        return new AllowAboveNRepValidator(10000).validate(post) &&
               new AllowOnlyTagValidator("r").validate(post) &&
               new AllowAllNewAnswersValidator().validate(post);
    }


    @Override
    public String descriptor() {
        return "Not a new answer posted by a high rep user on an old question tagged R";
    }

}
