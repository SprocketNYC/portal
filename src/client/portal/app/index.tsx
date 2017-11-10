import React, { ReactType } from "react";
import { render } from "react-dom";
import { AppContainer } from "react-hot-loader";
import App from "./App";

const renderRoot = (Comp: ReactType) => {
    render(
        <AppContainer>
            <Comp />
        </AppContainer>,
        document.getElementById("root"),
    );
};

renderRoot(App);

if (module.hot) {
    module.hot.accept();
}
