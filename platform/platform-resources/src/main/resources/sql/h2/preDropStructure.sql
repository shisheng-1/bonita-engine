-- ------------------------------------------------ Foreign Keys -----------------------------------------------
ALTER TABLE actor DROP CONSTRAINT fk_actor_tenantId;
ALTER TABLE actormember DROP CONSTRAINT fk_actormember_tenantId;
ALTER TABLE actormember DROP CONSTRAINT fk_actormember_actorId;
-- ALTER TABLE queriable_log DROP CONSTRAINT fk_queriable_log_tenantId;
ALTER TABLE queriablelog_p DROP CONSTRAINT fk_queriablelog_p_tenantId;
ALTER TABLE category DROP CONSTRAINT fk_category_tenantId;
ALTER TABLE command DROP CONSTRAINT fk_command_tenantId;
ALTER TABLE connector_instance DROP CONSTRAINT fk_connector_instance_tenantId;
ALTER TABLE data_instance DROP CONSTRAINT fk_data_instance_tenantId;
ALTER TABLE dependency DROP CONSTRAINT fk_dependency_tenantId;
ALTER TABLE dependencymapping DROP CONSTRAINT fk_dependencymapping_tenantId;
ALTER TABLE document DROP CONSTRAINT fk_document_tenantId;
ALTER TABLE document_mapping DROP CONSTRAINT fk_document_mapping_tenantId;
ALTER TABLE document_mapping DROP CONSTRAINT fk_docmap_docid;
ALTER TABLE event_trigger_instance DROP CONSTRAINT fk_event_trigger_instance_tenantId;
ALTER TABLE external_identity_mapping DROP CONSTRAINT fk_external_identity_mapping_tenantId;
ALTER TABLE flownode_instance DROP CONSTRAINT fk_flownode_instance_tenantId;
ALTER TABLE group_ DROP CONSTRAINT fk_group__tenantId;
ALTER TABLE job_desc DROP CONSTRAINT fk_job_desc_tenantId;
ALTER TABLE job_param DROP CONSTRAINT fk_job_param_tenantId;
ALTER TABLE message_instance DROP CONSTRAINT fk_message_instance_tenantId;
ALTER TABLE custom_usr_inf_def DROP CONSTRAINT fk_custom_usr_inf_def_tenantId;
ALTER TABLE custom_usr_inf_val DROP CONSTRAINT fk_custom_usr_inf_val_tenantId;
ALTER TABLE pending_mapping DROP CONSTRAINT fk_pending_mapping_tenantId;
ALTER TABLE pending_mapping DROP CONSTRAINT fk_pending_mapping_flownode_instanceId;
ALTER TABLE processcategorymapping DROP CONSTRAINT fk_processcategorymapping_tenantId;
ALTER TABLE process_comment DROP CONSTRAINT fk_process_comment_tenantId;
ALTER TABLE process_definition DROP CONSTRAINT fk_process_definition_tenantId;
ALTER TABLE process_definition DROP CONSTRAINT fk_process_definition_content;
ALTER TABLE process_instance DROP CONSTRAINT fk_process_instance_tenantId;
ALTER TABLE processsupervisor DROP CONSTRAINT fk_processsupervisor_tenantId;
ALTER TABLE profile DROP CONSTRAINT fk_profile_tenantId;
ALTER TABLE profilemember DROP CONSTRAINT fk_profilemember_tenantId;
ALTER TABLE multi_biz_data DROP CONSTRAINT fk_multi_biz_data_tenantId;
ALTER TABLE ref_biz_data_inst DROP CONSTRAINT fk_ref_biz_data_inst_tenantId;
ALTER TABLE role DROP CONSTRAINT fk_role_tenantId;
ALTER TABLE user_ DROP CONSTRAINT fk_user__tenantId;
ALTER TABLE user_membership DROP CONSTRAINT fk_user_membership_tenantId;
ALTER TABLE waiting_event DROP CONSTRAINT fk_waiting_event_tenantId;

ALTER TABLE profilemember DROP CONSTRAINT fk_profilemember_profileId;
-- ALTER TABLE process_comment DROP CONSTRAINT fk_process_comment_process_instanceId;

-- business application
ALTER TABLE business_app_menu DROP CONSTRAINT fk_app_menu_tenantId;
ALTER TABLE business_app_menu DROP CONSTRAINT fk_app_menu_appId;
ALTER TABLE business_app_menu DROP CONSTRAINT fk_app_menu_pageId;
ALTER TABLE business_app_menu DROP CONSTRAINT fk_app_menu_parentId;
ALTER TABLE business_app_page DROP CONSTRAINT fk_app_page_tenantId;
ALTER TABLE business_app_page DROP CONSTRAINT fk_bus_app_id;
ALTER TABLE business_app_page DROP CONSTRAINT fk_page_id;
ALTER TABLE business_app DROP CONSTRAINT fk_app_profileId;
ALTER TABLE business_app DROP CONSTRAINT fk_app_tenantId;
ALTER TABLE business_app DROP CONSTRAINT fk_app_layoutId;
ALTER TABLE business_app DROP CONSTRAINT fk_app_themeId;



--  ------------------------ Foreign Keys to disable if archiving is on another BD ------------------
ALTER TABLE arch_document_mapping DROP CONSTRAINT fk_arch_document_mapping_tenantId;
ALTER TABLE arch_document_mapping DROP CONSTRAINT fk_archdocmap_docid;
ALTER TABLE arch_flownode_instance DROP CONSTRAINT fk_arch_flownode_instance_tenantId;
ALTER TABLE arch_process_comment DROP CONSTRAINT fk_arch_process_comment_tenantId;
ALTER TABLE arch_process_instance DROP CONSTRAINT fk_arch_process_instance_tenantId;
ALTER TABLE arch_data_instance DROP CONSTRAINT fk_arch_data_instance_tenantId;
