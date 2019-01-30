<h:body>
  <h:form>
    <h:panelGrid columns="3">
      <h:outputLabel value="Name|Email:"
                     for="userNameEmail" />
      <h:inputText id="userNameEmail"
                   value="#{userBean.user}"
                   converter="userConverter"
                   validator="userValidator" />
      <h:message for="userNameEmail" />
    </h:panelGrid>
    <h:commandButton value="Validate"
                     action="#{userBean.userAction()}" />
  </h:form>
</h:body>