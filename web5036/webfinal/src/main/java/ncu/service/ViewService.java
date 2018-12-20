package ncu.service;

import ncu.dto.*;

public interface ViewService {
    Result<DownloadChatExecution> downloadChat(String currentId);
    Result<HomeExecution> home(String currentId);
    Result<LabelFriendExecution> labelFriend(String currentId);
    Result<ManagerFriendExecution> managerFriend(String currentId);
    Result<SelfInformationExecution> selfInformation(String currentId);
    Result<SelfLabelExecution> selfLabel(String currentId);
    Result<VerificationExecution> verification(String currentId);
}
