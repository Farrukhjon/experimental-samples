package org.farrukh.examples.service.currentuser;

import org.farrukh.examples.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
