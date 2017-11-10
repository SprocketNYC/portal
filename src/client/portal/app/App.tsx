import { SFC } from "react";
import { Comp } from "sample-module";
import styles from "./App.scss";
import Panel from "./Panel";

const App: SFC<{}> = () => (
    <div className={styles.AppClass}>
        <Panel text="Dean Jones" />
        <Comp />
    </div>
);

export default App;
