import angular from 'angular';

module Portal {
    export class DemoController {
        static $inject: string[] = ['$http'];

        public tstatus: string = '[READY]';
        public results: string = '';
        public working: boolean = false;
        public tstarts: number;

        constructor(private $http: ng.IHttpService) {
            this.doServiceGET('/demo/users/finduser');
        }

        private static timestamp(): number {
            if ((performance) && (performance.now())) {
                return performance.now();
            }
            if (!Date.now()) {
                return new Date().getTime();
            }
            return Date.now();
        }

        public statusREADY(path: string, response: any): void {
            let dt = (DemoController.timestamp() - this.tstarts);
            this.tstatus = `[READY] ${path} ${dt.toFixed(2)}.ms`;
            this.results = JSON.stringify(response.data, null, 2);
            this.working = false;
        }

        public statusERROR(path: string, response: any): void {
            let dt = (DemoController.timestamp() - this.tstarts);
            this.tstatus = `[ERROR] ${path} ${dt.toFixed(2)}.ms`;
            if (response.status < 0) {
                this.results = " NO NETWORK";
            } else {
                this.results = ` CODE[${response.status}]: ${response.statusText}`;
            }
            this.working = false;
        }

        public doServiceGET(path: string): void {
            this.working = true;
            this.tstatus = '[WORKING]';
            this.results = "";
            this.tstarts = DemoController.timestamp();
            this.$http.get('services' + path).then((response: any) => {
                this.statusREADY(path, response);
            }, (response: any) => {
                this.statusERROR(path, response);
            });
        }

        public doServicePOST(path: string, data: any): void {
            this.working = true;
            this.tstatus = '[WORKING]';
            this.results = "";
            this.tstarts = DemoController.timestamp();
            this.$http.post('services' + path, data).then((response: any) => {
                this.statusREADY(path, response);
            }, (response: any) => {
                this.statusERROR(path, response);
            });
        }
    }

    angular.module('portal', [])
        .controller('demoController', DemoController);
}