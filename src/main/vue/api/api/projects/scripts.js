


export default (DDLScript) => ({

	list: async (project_id) => await DDLScript.get(
		"/projects/" + project_id + "/scripts"
	),

	create: async (project_id, payload) => await DDLScript.post(
		"/projects/" + project_id + "/scripts"
		, {}
		, {
			title: payload.title
		}
	),

	update: async (project_id, script_id, payload) => await DDLScript.patch(
		"/projects/" + project_id + "/scripts/" + script_id
		, {}
		, {
			title: payload.title
		}
	),

});