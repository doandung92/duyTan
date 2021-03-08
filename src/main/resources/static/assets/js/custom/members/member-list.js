let KTDatatableRemoteAjaxMemberList = function () {
    let initTable = function () {
        $('#kt_datatable').KTDatatable({
            data:{
                type: "remote",
                source: {
                    read: {
                        url : "api/members/datatables",
                        method : "GET",
                        map: function (raw) {
                           let dataSet = raw;
                            if (typeof raw.data !== 'undefined') {
                                dataSet = raw.data;
                            }
                           return dataSet;
                        }
                    }
                }
            },
            layout:{
                scroll: false,
                footer: false,
            },
            columns: [{
                field: 'memberId',
                title: '#',
                sortable: 'asc',
                width: 50,
                type: 'number',
                selector: false,
                textAlign: 'center',
            },{
                field: 'name',
                title: 'NAME',
                width: 150,
                sortable: 'asc',
            },{
                field: 'email',
                title: 'EMAIL',
                width: 150,
                sortable: false,
            },{
                field: 'phoneNumber',
                title: 'PHONE',
                width: 150,
                sortable: false,
            },{
                field: 'password',
                title: 'PASSWORD',
                width: 150,
                sortable: false,
            },{
                field: 'useFlag',
                title: 'ACTIVE',
                width: 80,
                sortable: false,
                template: function (data) {
                    return renderActiveStatusOnList(data)
                }
            }
            ]
        });
    };
    return {
        init : function () {
            initTable();
        }
    }
}();

jQuery(document).ready(function () {
    KTDatatableRemoteAjaxMemberList.init();
})
