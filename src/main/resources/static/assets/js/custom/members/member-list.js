let KTDatatableRemoteAjaxMemberList = function () {
    let initTable = function () {
       var datatable = $('#kt_datatable').KTDatatable({
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
                            $(".total-header").html(
                                "<p> Member | "+ dataSet.length+ " Total"+"</p>")
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
                field: 'useFlag',
                title: 'ACTIVE',
                width: 80,
                sortable: false,
                template: function (data) {
                    let status ={
                        1:{title: "Active", state: "success"},
                        2:{title: "inActive", state: "danger"}
                    };
                    let statusNo = data.useFlag;
                    if (statusNo === "Y")
                        statusNo = 1;
                    if (statusNo === "N")
                        statusNo = 2;
                    return `<span class="label label-${status[statusNo].state} label-dot mr-2"></span>
                            <span class="font-weight-bold text-${status[statusNo].state}">${status[statusNo].title}</span>`
                }
            },{
                field: "Actions",
                title: "ACTIONS",
                width: 80,
                sortable: false,
                textAlign: 'center',
                overflow: 'visible',
                template: function (data) {
                    return `<div class="dropdown dropdown-inline">
                    <a href="javascript:;" class="btn btn-sm btn-light btn-text-primary btn-icon mr-2" data-toggle="dropdown">
                        <i class="flaticon-more-1"></i>
                    </a>
                      <div class="dropdown-menu dropdown-menu-sm dropdown-menu-left">
                        <ul class="nav nav-hoverable flex-column">
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-edit"></i><span class="nav-text">Edit Details</span></a></li>
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-refresh"></i><span class="nav-text">Change Members</span></a></li>
                        </ul>
                      </div>
                </div>`
                },

            }
            ],
        });
        $("#kt_datatable_search_name").on("change keyup paste", function () {
            datatable.search($(this).val().toLowerCase(), "name");
        })
        $("#kt_datatable_search_active").on("change", function () {
            datatable.search($(this).val().toLowerCase(), "useFlag");
            console.log($(this).val());
        });
        $("#kt_reset").on("click",function (e) {
            e.preventDefault()
            $(".datatable-input").each(function () {
                $(this).val('').change();
                // console.log($(this).name())
                datatable.search($(this).val(),"useFlag");
            });

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

